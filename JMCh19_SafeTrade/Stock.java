import java.util.*;
import java.lang.reflect.*;
import java.text.DecimalFormat;


/**
 * Represents a stock in the SafeTrade project
 */
public class Stock
{
    public static DecimalFormat money = new DecimalFormat( "0.00" );

    private String stockSymbol;

    private String companyName;

    private double loPrice, hiPrice, lastPrice;

    private int volume;

    private PriorityQueue<TradeOrder> buyOrders, sellOrders;


    public Stock( String symbol, String name, double price )
    {
        stockSymbol = symbol;
        companyName = name;
        loPrice = price;
        hiPrice = price;
        lastPrice = price;
        volume = 0;

        buyOrders = new PriorityQueue<TradeOrder>( 10, new PriceComparator() );
        sellOrders = new PriorityQueue<TradeOrder>( 10, new PriceComparator( false ) );
    }


    public String getQuote()
    {
        String quote = companyName + " (" + stockSymbol + ")" + "\n" + "Price: " + lastPrice + " hi: " + hiPrice
            + " lo: " + loPrice + " vol: " + volume + "\n";

        if ( sellOrders.isEmpty() )
        {
            if ( buyOrders.isEmpty() )
                return quote;

            return quote += "Ask: none" + " Bid: " + buyOrders.peek().getPrice() + " size: "
                + buyOrders.peek().getShares();
        }
        else
        {
            if ( buyOrders.isEmpty() )
                return quote += "Ask: " + sellOrders.peek().getPrice() + " size: " + sellOrders.peek().getShares()
                    + " Bid: none\n";

            return quote += "Ask: " + sellOrders.peek().getPrice() + " size: " + sellOrders.peek().getShares()
                + " Bid: " + buyOrders.peek().getPrice() + " size: " + buyOrders.peek().getShares();
        }
    }


    public void placeOrder( TradeOrder order )
    {
        String msg = "";

        if ( order == null )
        {
            return;
        }

        if ( order.isBuy() )
        {
            buyOrders.add( order );

            msg = "New order: Buy " + order.getSymbol() + "(" + companyName + ")" + "\n" + order.getShares()
                + " shares at ";

            if ( order.isMarket() )
            {
                msg += "market";
            }
            else if ( order.isLimit() )
            {
                msg += money.format( order.getPrice() );
            }

        }
        else if ( order.isSell() )
        {
            sellOrders.add( order );

            msg = "New order: Sell " + order.getSymbol() + "(" + companyName + ")" + "\n" + order.getShares()
                + " shares at ";

            if ( order.isMarket() )
            {
                msg += "market";
            }
            else if ( order.isLimit() )
            {
                msg += money.format( order.getPrice() );
            }
        }

        order.getTrader().receiveMessage( msg );
        executeOrders();
    }


    protected void executeOrders()
    {
        /*
         * if ( buyOrders.isEmpty() || sellOrders.isEmpty() ) { return; }
         */

        while ( !buyOrders.isEmpty() && !sellOrders.isEmpty() )
        {
            TradeOrder buy = buyOrders.peek();
            TradeOrder sell = sellOrders.peek();

            Trader buyer = buy.getTrader();
            Trader seller = sell.getTrader();

            int shares = 0;
            double price = 0;

            if ( ( buy.isLimit() && sell.isLimit() ) && buy.getPrice() >= sell.getPrice() )
            {
                price = sell.getPrice();
            }
            else if ( buy.isLimit() && sell.isMarket() )
            {
                price = buy.getPrice(); // executes order with buy order price
                                        // (limit order price)
            }
            else if ( buy.isMarket() && sell.isLimit() )
            {
                price = sell.getPrice(); // executes order with sell order price
                                         // (limit order)
            }
            else if ( buy.isMarket() && sell.isMarket() )
            {
                price = lastPrice; // executes order with last sale price
            }
            else // sell price > buy price
            {
                return;
            }

            if ( buy.getShares() > sell.getShares() )
            {
                shares = sell.getShares();
            }
            else
            {
                shares = buy.getShares();
            }

            buy.subtractShares( shares );
            sell.subtractShares( shares );

            if ( buy.getShares() == 0 )
            {
                buyOrders.remove( buy );
            }

            if ( sell.getShares() == 0 )
            {
                sellOrders.remove( sell );
            }

            if ( price < loPrice )
            {
                loPrice = price;
            }

            if ( price > hiPrice )
            {
                hiPrice = price;
            }

            volume += shares;
            lastPrice = price;

            buyer.receiveMessage( "You bought: " + shares + " " + stockSymbol + " at " + money.format( price ) + " amt "
                + money.format( shares * price ) );
            seller.receiveMessage( "You sold: " + shares + " " + stockSymbol + " at " + money.format( price ) + " amt "
                + money.format( shares * price ) );
        }

        /*
         * if ( !buyOrders.isEmpty() && !sellOrders.isEmpty() ) {
         * executeOrders(); }
         */

    }


    //
    // The following are for test purposes only
    //

    protected String getStockSymbol()
    {
        return stockSymbol;
    }


    protected String getCompanyName()
    {
        return companyName;
    }


    protected double getLoPrice()
    {
        return loPrice;
    }


    protected double getHiPrice()
    {
        return hiPrice;
    }


    protected double getLastPrice()
    {
        return lastPrice;
    }


    protected int getVolume()
    {
        return volume;
    }


    protected PriorityQueue<TradeOrder> getBuyOrders()
    {
        return buyOrders;
    }


    protected PriorityQueue<TradeOrder> getSellOrders()
    {
        return sellOrders;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Stock.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getType().getName() + " " + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}