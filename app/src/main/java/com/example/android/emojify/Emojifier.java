package com.example.android.emojify;

// TODO (2): Create a static method in the Emojifier class called detectFaces() which detects and logs the number of faces in a given bitmap.

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;


public class Emojifier {

    // How to use Google mobile vision library
    // https://developers.google.com/vision/android/detect-faces-tutorial
    public static void detectFaces(Context context, Bitmap picture){


        // Create the face detector, disable tracking and enable classifications
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        // Build the frame
        Frame frame = new Frame.Builder().setBitmap(picture).build();

        // Detect the  faces
        SparseArray<Face> faces = detector.detect(frame);

        // Log the number of faces
        Log.d("FACE_LOG", "detectFaces: number of faces = " + faces.size());


        // If there are no faces detected, show a Toast message
        if(faces.size() == 0){
            Toast.makeText(context, "No Faces Detected", Toast.LENGTH_SHORT).show();
        }

        // Release the detector
        detector.release();



    }
}
