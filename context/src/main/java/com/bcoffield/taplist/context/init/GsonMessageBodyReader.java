package com.bcoffield.taplist.context.init;

import com.bcoffield.taplist.server.util.GsonUtil;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Singleton
public class GsonMessageBodyReader<T> implements MessageBodyReader<T> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType,
            Annotation[] antns, MediaType mt) {
        return true;
    }

    @Override
    public T readFrom(Class<T> type, Type genericType,
            Annotation[] antns, MediaType mt,
            MultivaluedMap<String, String> mm, InputStream in)
            throws IOException, WebApplicationException {
        return GsonUtil.getGson().fromJson(_convertStreamToString(in), type);
    }

    private String _convertStreamToString(InputStream inputStream)
            throws IOException {
        if (inputStream != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(
                        new InputStreamReader(inputStream, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                inputStream.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }
}