package br.edu.ifpb.pos.restlet;

public class ViewSubject {
  private static ViewObserver observer;
  
  public static void setObserver(ViewObserver o){
    observer = o;
  }
  
  public static void notifyObserver(final AGImage image){
    Thread t = new Thread(){
      public void run() {
        observer.update(image);
      };
    };
    t.start();
  }

}
