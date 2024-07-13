package nio;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        String sourceFilePath = "F:\\BufferChannelExp.txt";
        String destFilePath = "F:\\CopyOfBufferChannelExp.txt";
        Path source = Paths.get(sourceFilePath);
        Path dest = Paths.get(destFilePath);

        if(!dest.toFile().exists()) {
            dest.toFile().createNewFile();
        }

        try(FileChannel readFileChannel = FileChannel.open(source, StandardOpenOption.READ);
            FileChannel writeFileChannel = FileChannel.open(dest, StandardOpenOption.WRITE);){
            readFileChannel.transferTo(0, readFileChannel.size(), writeFileChannel);
        }
    }
}
