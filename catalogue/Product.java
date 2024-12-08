package catalogue;

import java.io.Serializable;

/**
 * Used to hold the following information about
 * a product: Product number, Description, Price, Stock level.
 * @author  Mike Smith University of Brighton
 * @version 2.0
 */

public class Product implements Serializable, Comparable<Product>
{
  private static final long serialVersionUID = 20092506;
  private String theProductNum;       // Product number
  private String theDescription;      // Description of product
  private double thePrice;            // Price of product
  private int    theQuantity;         // Quantity involved

  /**
   * Construct a product details
   * @param aProductNum Product number
   * @param aDescription Description of product
   * @param aPrice The price of the product
   * @param aQuantity The Quantity of the product involved
   */
  public Product( String aProductNum, String aDescription,
                  double aPrice, int aQuantity )
  {
    theProductNum  = aProductNum;     // Product number
    theDescription = aDescription;    // Description of product
    thePrice       = aPrice;          // Price of product
    theQuantity    = aQuantity;       // Quantity involved
  }
  
  public String getProductNum()  { return theProductNum; }
  public String getDescription() { return theDescription; }
  public double getPrice()       { return thePrice; }
  public int    getQuantity()    { return theQuantity; }
 
  
  
  public void setProductNum( String aProductNum )
  { 
    theProductNum = aProductNum;
  }
  
  public void setDescription( String aDescription )
  { 
    theDescription = aDescription;
  }
  
  public void setPrice( double aPrice )
  { 
    thePrice = aPrice;
  }
  
  public void setQuantity( int aQuantity )
  { 
    theQuantity = aQuantity;
  }

@Override
public boolean equals(Object obj) {

	if (this == obj) return true;
	if (obj == null || getClass() != obj.getClass()) return false;
	
	Product p = (Product) obj;
	return theProductNum.equals(p.theProductNum);
	
}

@Override
public int compareTo(Product toCompare) {
	int a = Integer.parseInt(theProductNum);
	int b = Integer.parseInt(toCompare.theProductNum);
	
	if (a > b) {
		return 1;
	} else if (a < b) {
		return -1;
	} else {
		return 0;
	}
	

}

}
