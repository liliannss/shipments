package com.example.shipments.configs

import org.springframework.context.annotation.Configuration

@Configuration
class FileConfig {

    static BufferedWriter bufferedWriter
    private static PATH = "./src/main/resources/shipments/"
    private static EXTENSION = ".txt"

    static BufferedWriter setup(String fileName) {
        bufferedWriter = new BufferedWriter(new FileWriter(new File(PATH + fileName + EXTENSION)))
    }

    static void writer(String line) {
        bufferedWriter.write(line)
        bufferedWriter.newLine()
    }

    static void flush() {
        bufferedWriter.flush()
    }

    static void close() {
        bufferedWriter.close()
    }

}