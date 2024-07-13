package nio;

import jdk.dynalink.StandardOperation;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteFileUsingBufferAndChannel {
    public static void main(String[] args) throws IOException {
        String filePath = "F:\\BufferChannelExp.txt";
        Path path = Paths.get(filePath);
        String content = "Hello World!!!\n" +
                "How are you all?\n" +
                "Are you enjoing?\n\n";

        ByteBuffer byteBuffer = ByteBuffer.wrap(content.getBytes());

        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.APPEND)) {
            fileChannel.write(byteBuffer);
        }
    }
}
