package nio;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadFromFileUsingBufferAndChannel {
    public static void main(String[] args) throws IOException {
        String filePath = "F:\\BufferChannelExp.txt";
        Path path = Paths.get(filePath);

        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(512);
            int bytesRead = fileChannel.read(buffer);

            while(bytesRead != -1) {
                buffer.flip();
                while(buffer.hasRemaining()) {
                    System.out.print((char)buffer.get());
                }
                buffer.clear();
                bytesRead = fileChannel.read(buffer);
            }
        }
    }
}
