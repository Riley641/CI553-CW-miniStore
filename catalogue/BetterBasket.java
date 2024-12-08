package catalogue;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

/**
 * Write a description of class BetterBasket here.
 * 
 * @author  Your Name 
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable
{

private static final long serialVersionUID = 1L;
 
  
  
  
  private boolean merge(Product pr) {
	  int p = indexOf(pr);
	  if (p >= 0) {
		  Product toChange = this.get(p);
		  toChange.setQuantity(toChange.getQuantity() + 1);
		  return true;
	  } else {
		  return false;
	  }
  }
  
  
  
  // You need to add code here
  // merge the items for same product,
  // or sort the item based on the product number
  @Override
  public boolean add( Product pr )
  {                              
	  if (merge(pr)) {
		  return true;
	  } else {
		  this.add(this.size(), pr);
		  return false;
	  }
  }

}
