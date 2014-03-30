package triangle;
public class triangle {

    static final int ILLEGAL_ARGUMENTS = -2;

    static final int ILLEGAL = -3;

    static final int SCALENE = 1;

    static final int EQUILATERAL = 2;

    static final int ISOCELES = 3;
    
    // La fonction main joue ici le role d'un driver est ne doit pas etre sujet ?des test
    public static void main( java.lang.String[] args )
    {
        float[] s;
        s = new float[args.length];
        for(int i = 0 ; i< args.length; i++)
        {
        	s[i] = new java.lang.Float(args[i]);
        }
        System.out.println( getType( s ) );
    }

    public static int getType( float[] sides )
    {
        int ret = 0;
        float side1  = sides[0];
        float side2  = sides[1];
        float side3  = sides[2];
        
        if (sides.length != 3) {
            ret = ILLEGAL_ARGUMENTS;
        } else {
            if (side1 < 0 || side2 < 0 || side3 < 0) {
                ret = ILLEGAL_ARGUMENTS;
            } else {
                int triang = 0;
                if (side1 == side2) {
                    triang = triang + 1;
                }
                if (side2 == side3) {
                    triang = triang + 2;
                }
                if (side1 == side3) {
                    triang = triang + 3;
                }
                if (triang == 0) {
                    if (side1 + side2 < side3 || side2 + side3 < side1 || side1 + side3 < side2) {
                        ret = ILLEGAL;
                    } else {
                        ret = SCALENE;
                    }
                } else {
                    if (triang > 3) {
                        ret = EQUILATERAL;
                    } else {
                        if (triang == 1 && side1 + side2 > side3) {
                            ret = ISOCELES;
                        } else {
                            if (triang == 2 && side2 + side3 > side1) {
                                ret = ISOCELES;
                            } else {
                                if (triang == 3 && side1 + side3 > side2) {
                                    ret = ISOCELES;
                                } else {
                                    ret = ILLEGAL;
                                }
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }

}
