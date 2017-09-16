public class DanceRunner
{
  public static void main(String[] args)
  {
    int k = (int)(3 * Math.random());
    switch (k)
    {
      case 0:
        (new WaltzNumber()).main(args); break;
      case 1:
        (new YMCANumber()).main(args); break;
      case 2:
        (new CongaNumber()).main(args); break;
    }
  }
}