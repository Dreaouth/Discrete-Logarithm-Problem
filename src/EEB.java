import java.math.BigInteger;

public class EEB {
	public static BigInteger extendedEuclidAlgrothm(BigInteger r0, BigInteger r1) throws Exception {
		if (!isCoPrime(r0, r1)) {
			throw new Exception("输入的两个数必须互素");
		}
		BigInteger a = r0, b = r1;
		if (r0.compareTo(r1) < 0) {
			BigInteger temp = r0;
			r0 = r1;
			r1 = temp;
		}
		BigInteger r2;
		BigInteger q;
		BigInteger s0 = BigInteger.ONE, s1 = BigInteger.ZERO, s2;
		BigInteger t0 = BigInteger.ZERO, t1 = BigInteger.ONE, t2;
		int i = 0;
		while (!r1.equals(BigInteger.ZERO)) {
			r2 = r0.mod(r1);
			q = r0.divide(r1);
			s2 = s0.subtract(q.multiply(s1));
			t2 = t0.subtract(q.multiply(t1));
			// System.out.println("i=" + i++ + " r=" + r2 + " q=" + q + " s=" +
			// s2 + " t=" + t2);
			r0 = r1;
			r1 = r2;
			s0 = s1;
			s1 = s2;
			t0 = t1;
			t1 = t2;
		}
		// System.out.println(a + "模" + b + "的乘法逆元为" + s0);
		// System.out.println(b + "模" + a + "的乘法逆元为" + t0);
		// System.out.println("化为正数为" + t0.add(a));
		return t0;
	}

	public static boolean isCoPrime(BigInteger r0, BigInteger r1) {
		BigInteger r2 = BigInteger.ZERO;
		while (!r1.equals(BigInteger.ZERO)) {
			r2 = r0.mod(r1);
			r0 = r1;
			r1 = r2;
		}
		if (r0.equals(BigInteger.ONE))
			return true;
		else
			return false;
	}
}
