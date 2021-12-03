abstract class Object{
  //Space pos;
  double speed;
  String fileName;
  int width;
  int height;

  abstract int getHeight();
  abstract int getWidth();
  //abstract Space getSpace();
  abstract String getFileName();
  abstract void update();
}