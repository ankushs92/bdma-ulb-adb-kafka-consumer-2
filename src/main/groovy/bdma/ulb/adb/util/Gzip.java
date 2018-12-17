package bdma.ulb.adb.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

/**
 * Created by Ankush on 16/02/17.
 */
public class Gzip {

    /**
     *
     * @param compressed the byte[] to decompress using gzip algorithm
     * @return
     */
    public static String decompress(final byte[] compressed) {
        Assert.notNull(compressed, "Cannot unzip null or empty byte[]");
        if (!isZipped(compressed)) {
            return new String(compressed);
        }

        try (final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed) ) {
            try (final GZIPInputStream gzipInputStream = new GZIPInputStream(byteArrayInputStream)) {
                try (final InputStreamReader inputStreamReader = new InputStreamReader(gzipInputStream, StandardCharsets.UTF_8)) {
                    try (final BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                        StringBuilder output = new StringBuilder();
                        String line;
                        while((line = bufferedReader.readLine()) != null ){
                            output.append(line);
                        }
                        return output.toString();
                    }
                }
            }
        }
        catch(final IOException e) {
            throw new RuntimeException("Failed  to unzip content", e);
        }
    }

    private static boolean isZipped(final byte[] compressed ) {
        return (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8));
    }


}
