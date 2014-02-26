package br.edu.ifpb.pos.restlet;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(
    name="root"
)
public class AGImage {
  private String image;

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
    
}
