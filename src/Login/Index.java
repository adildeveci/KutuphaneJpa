package Login;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class Index {
	
	  private List<String> images;
	     
	    @PostConstruct
	    public void init() {
	        images = new ArrayList<String>();
	        for (int i = 1; i <= 5; i++) {
	            images.add("resim" + i + ".jpg");
	        }
	    }
	 
	    public List<String> getImages() {
	        return images;
	    }

}
