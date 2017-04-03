import java.math.BigInteger;
import java.util.Scanner;

public class PollardsPho {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		BigInteger alpha = BigInteger.ZERO; // aΪ����Ԫ
		BigInteger beta = BigInteger.ZERO;
		BigInteger N = BigInteger.ZERO; // ѭ��ȺG
		System.out.println("������ѭ��Ⱥ������Ԫa");
		alpha = scanner.nextBigInteger();
		System.out.println("�����������b");
		beta = scanner.nextBigInteger();
		System.out.println("������ѭ��ȺG��Z*)");
		N = scanner.nextBigInteger();
		BigInteger[] x = new BigInteger[1000];
		x[0] = BigInteger.ZERO;
		BigInteger[] a = new BigInteger[1000];
		a[0] = BigInteger.ZERO;
		BigInteger[] b = new BigInteger[1000];
		b[0] = BigInteger.ZERO;
		boolean tag = false;
		for (int i = 1; i < 1000; i++) {
			x[i] = ((alpha.pow(a[i - 1].intValue())).multiply(beta.pow(b[i - 1].intValue()))).mod(N);
			// System.out.println(x[i]);
			int s = (x[i].mod(BigInteger.valueOf(3))).intValue();
			// System.out.println("s="+s);
			for (int j = 0; j < i; j++) {
				if (x[i].equals(x[j])) {
					System.out.println("��iΪ" + (i - 1) + "ʱ,����aiΪ" + a[i - 1] + ",biΪ" + b[i - 1]);
					System.out.println("��ʱ,jΪ" + (j - 1) + ",ajΪ" + a[j - 1] + ",bjΪ" + b[j - 1]);
					BigInteger c = b[j - 1].subtract(b[i - 1]);
					if (c.compareTo(BigInteger.ZERO) < 0)
						c = c.add(N.subtract(BigInteger.ONE));
					// System.out.println(c);
					c = EEB.extendedEuclidAlgrothm(c, N.subtract(BigInteger.ONE));
					// System.out.println(c);
					c = (c.multiply(a[i - 1].subtract(a[j - 1]))).mod(N.subtract(BigInteger.ONE));
					System.out
							.println("x=(" + a[i - 1] + "-" + a[j - 1] + ")/(" + b[j - 1] + "-" + b[i - 1] + ")=" + c);
					tag = true;
					break;
				}
			}
			switch (s) {
			case 0:
				a[i] = (a[i - 1].multiply(BigInteger.valueOf(4))).mod(N);
				b[i] = (b[i - 1].multiply(BigInteger.valueOf(5))).mod(N);
				break;
			case 1:
				a[i] = (a[i - 1].add(BigInteger.ONE)).mod(N);
				b[i] = b[i - 1];
				break;
			case 2:
				a[i] = a[i - 1];
				b[i] = (b[i - 1].add(BigInteger.ONE)).mod(N);
				break;
			default:
				break;
			}
			if (tag == true)
				break;
			// System.out.println("a="+a[i]+" b="+b[i]);
		}
	}
}
