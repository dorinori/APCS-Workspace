/**
 * A price comparator for trade orders.
 */
public class PriceComparator implements java.util.Comparator<TradeOrder>
{
    private boolean ascending;

    public PriceComparator()
    {
        ascending = true;
    }
    
    public PriceComparator( boolean asc )
    {
        ascending = asc;
    }
    
    public int compare( TradeOrder order1, TradeOrder order2 )
    {
        int price = 0;
        
        if( order1.isMarket() && order2.isMarket() )
        {
            price = 0;
        }
        else if( order1.isMarket() && order2.isLimit() )
        {
            price = -1;
        }
        else if( order1.isLimit() && order2.isMarket() )
        {
            price = 1;
        }
        else if( order1.isLimit() && order2.isLimit() )
        {
            if( order1.getPrice() > order2.getPrice() )
            {
                price = (int)( order1.getPrice() - order2.getPrice() );
            }
            else
            {
                price = (int)( order2.getPrice() - order1.getPrice() );
            }
        }
        
        return price;
    }

}