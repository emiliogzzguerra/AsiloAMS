package sample.clases;

import javafx.scene.image.Image;

public class setImage {

    public static Image setUpImage(String path){
        //Carga la imagen
        Image image = new Image(path, 145,135,false,false);
        return image;
    }
}
