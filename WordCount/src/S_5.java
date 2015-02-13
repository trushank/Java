public class  S_5 extends S_4   {

  String s = "S_5";

  public void a(String a)       {
          s = "set in S_5:" + a;
  }
  public void doTheJob()        {
        S_4 aS_4 = (S_4)this;
        a("1");
        b("2");
        System.out.println("1. s        = " + s );
        System.out.println("2. this.s   = " + this.s );
        System.out.println("3. aS_4     = " + aS_4.s );
        aS_4.a("3");
        System.out.println("4. this.s   = " + this.s );
        System.out.println("5. aS_4     = " + aS_4.s );
  }

  public static void main(String args[] )       {
        new S_5().doTheJob();
  }
}