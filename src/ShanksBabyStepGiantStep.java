import java.math.BigInteger;
import java.util.Scanner;

public class ShanksBabyStepGiantStep {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		BigInteger a; // aΪ����Ԫ
		BigInteger b;
		Long c; // ѭ��ȺG
		System.out.println("������ѭ��Ⱥ������Ԫa");
		a = scanner.nextBigInteger();
		System.out.println("�����������b");
		b = scanner.nextBigInteger();
		System.out.println("������ѭ��ȺG��Z*)");
		c = scanner.nextLong();
		BigInteger m = BigInteger.valueOf((long) Math.ceil(Math.sqrt(c - 1))); // mΪ������c�Ľ�
		System.out.println("Z" + c + "*�Ľ�Ϊ" + (c - 1));
		System.out.println("�Ը���" + (c - 1) + "��������ȡ������mΪ" + m);
		BigInteger[] Xb = new BigInteger[m.intValue()];
		for (int i = 0; i < m.intValue(); i++) {
			Xb[i] = a.pow(i).mod(BigInteger.valueOf(c));
			System.out.print("Xb[" + i + "]=" + Xb[i] + "  ");
		}
		System.out.println();
		BigInteger[] Xg = new BigInteger[m.intValue()];
		BigInteger d = a.pow(m.intValue()).mod(BigInteger.valueOf(c));
		BigInteger x = BigInteger.ZERO; // ��ɢ����
		BigInteger xLong = EEB.extendedEuclidAlgrothm(new BigInteger(d.toString()), new BigInteger(c.toString())); // ����a��-m�η�
		if (xLong.compareTo(BigInteger.ZERO) < 0)
			xLong = xLong.add(BigInteger.valueOf(c));
		System.out.println("a��-m�η�ģѭ��ȺGΪ" + xLong);
		for (int i = 0; i < m.intValue(); i++) {
			Xg[i] = (xLong.pow(i).multiply(b)).mod(BigInteger.valueOf(c));
			System.out.print("Xg[" + i + "]=" + Xg[i] + "  ");
			for (int j = 0; j < m.intValue(); j++) {
				if (Xg[i].equals(Xb[j])) {
					System.out.println();
					System.out.println("����XbΪ" + j + ",XgΪ" + i);
					x = (m.multiply(BigInteger.valueOf(i))).add(BigInteger.valueOf(j));
					System.out.println("x=Xg*m+Xb=" + x);
					break;
				}
			}
			if (x.intValue() != 0)
				break;
		}
	}
}
