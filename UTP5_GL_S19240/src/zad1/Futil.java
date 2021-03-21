//package zad1;
//
//import java.io.*;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.*;
//import java.nio.file.attribute.BasicFileAttributes;
//
//public class Futil {
//    public static void processDir(String dirName, String resultFileName) {
//        try {
//            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultFileName), StandardCharsets.UTF_8));
//            PrintWriter writer = new PrintWriter(bufferedWriter);
//            Files.walkFileTree(Paths.get(dirName), new SimpleFileVisitor<Path>() {
//                @Override
//
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
//                    try {
//                        for (String l : Files.readAllLines(file)) {
//                            writer.write(l);
//                            writer.flush();
//                            writer.println();
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
