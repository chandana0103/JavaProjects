package com.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.AmazonPolly;
import com.amazonaws.services.polly.AmazonPollyClientBuilder;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest;
import com.amazonaws.services.polly.model.SynthesizeSpeechResult;

public class pollyDemo {

    // AWS credentials
    private static final String ACCESS_KEY = "AKIA4V5ES62UAGI6VVPP";
    private static final String SECRET_KEY = "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";
    
    public static void main(String[] args) {
        // Text to convert to speech
        String text = "Hello sravni , how are you. welcome to the text-to-speech converter using AWS Polly and Java.";

        // Set up AWS credentials
        BasicAWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        AmazonPolly polly = AmazonPollyClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1)  // Choose your desired AWS region
                .build();

        // Convert text to speech
        SynthesizeSpeechRequest synthesizeSpeechRequest = new SynthesizeSpeechRequest()
                .withText(text)
                .withOutputFormat(OutputFormat.Mp3)
                .withVoiceId("Joanna");  // Choose a voice (e.g., Joanna, Matthew, etc.)

        try {
            SynthesizeSpeechResult synthesizeSpeechResult = polly.synthesizeSpeech(synthesizeSpeechRequest);
            byte[] audioBytes = synthesizeSpeechResult.getAudioStream().readAllBytes();

            // Save the audio to a file
            try (FileOutputStream outputStream = new FileOutputStream("output.mp3")) {
                outputStream.write(audioBytes);
                System.out.println("Speech synthesis complete. Audio saved to output.mp3");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
