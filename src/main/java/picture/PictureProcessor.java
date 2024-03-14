package picture;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static java.lang.Integer.min;

public class PictureProcessor {
  public Picture invert(Picture picture) {
    int width = picture.getWidth();
    int height = picture.getHeight();
    Color current;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j ++) {
        current = picture.getPixel(j, i);
        picture.setPixel(j, i, new Color(255 - current.getRed(),
                255 - current.getGreen(), 255 - current.getBlue()));
      }
    }
    return picture;
  }

  public Picture grayscale(Picture picture) {
    int width = picture.getWidth();
    int height = picture.getHeight();
    Color current;
    int average;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j ++) {
        current = picture.getPixel(j, i);
        average = (current.getRed() + current.getGreen() + current.getBlue()) / 3;
        picture.setPixel(j, i, new Color(average, average, average));
      }
    }
    return picture;
  }

  public Picture flip(char reflection, @NotNull Picture picture) {
    int width = picture.getWidth();
    int height = picture.getHeight();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        switch (reflection) {
          case 'H':
            picture.setPixel(width-j-1, i, picture.getPixel(j, i));
          case 'V':
            picture.setPixel(j, height-i-1, picture.getPixel(j, i));
          default:
            throw new UnsupportedOperationException();
        }
      }
    }
    return picture;
  }

  public static void main(String[] args) {
    // TODO: Implement this.
    System.err.println("TODO: Implement main");
  }
}
