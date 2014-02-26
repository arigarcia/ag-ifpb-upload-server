package br.edu.ifpb.pos.restlet;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class ImageResource extends ServerResource {

	@Post("xml")
	public StringRepresentation upload(Representation rep){
	  //
	  String result = "OK";
	  //
	  try {
	    JAXBContext ctx = JAXBContext.newInstance(AGImage.class);
	    Unmarshaller unmarshaller = ctx.createUnmarshaller();
	    AGImage image = (AGImage) unmarshaller.unmarshal(rep.getStream());
	    ViewSubject.notifyObserver(image);
	  }
	  catch (JAXBException e) {
      result = e.getMessage();
    }
	  catch (IOException e) {
      result = e.getMessage();
    }
    //
	  return new StringRepresentation(result);
	  
	}
	
}
