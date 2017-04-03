import java.math.BigInteger;
import java.util.Scanner;

public class ShanksBabyStepGiantStep {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		BigInteger a; // a为生成元
		BigInteger b;
		Long c; // 循环群G
		System.out.println("请输入循环群的生成元a");
		a = scanner.nextBigInteger();
		System.out.println("请输入给出的b");
		b = scanner.nextBigInteger();
		System.out.println("请输入循环群G（Z*)");
		c = scanner.nextLong();
		BigInteger m = BigInteger.valueOf((long) Math.ceil(Math.sqrt(c - 1))); // m为根号下c的阶
		System.out.println("Z" + c + "*的阶为" + (c - 1));
		System.out.println("对根号" + (c - 1) + "进行向上取整得数m为" + m);
		BigInteger[] Xb = new BigInteger[m.intValue()];
		for (int i = 0; i < m.intValue(); i++) {
			Xb[i] = a.pow(i).mod(BigInteger.valueOf(c));
			System.out.print("Xb[" + i + "]=" + Xb[i] + "  ");
		}
		System.out.println();
		BigInteger[] Xg = new BigInteger[m.intValue()];
		BigInteger d = a.pow(m.intValue()).mod(BigInteger.valueOf(c));
		BigInteger x = BigInteger.ZERO; // 离散对数
		BigInteger xLong = EEB.extendedEuclidAlgrothm(new BigInteger(d.toString()), new BigInteger(c.toString())); // 计算a的-m次方
		if (xLong.compareTo(BigInteger.ZERO) < 0)
			xLong = xLong.add(BigInteger.valueOf(c));
		System.out.println("a的-m次方模循环群G为" + xLong);
		for (int i = 0; i < m.intValue(); i++) {
			Xg[i] = (xLong.pow(i).multiply(b)).mod(BigInteger.valueOf(c));
			System.out.print("Xg[" + i + "]=" + Xg[i] + "  ");
			for (int j = 0; j < m.intValue(); j++) {
				if (Xg[i].equals(Xb[j])) {
					System.out.println();
					System.out.println("存在Xb为" + j + ",Xg为" + i);
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
