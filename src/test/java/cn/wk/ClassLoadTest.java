package cn.wk;

import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.Opcodes;

public class ClassLoadTest extends ClassLoader{

	public static void test1(String[] args) {
		int j=0;
		try{
			ClassLoadTest t=new ClassLoadTest();
			for (int i = 0; i < 10; i++,j++) {
				ClassWriter cw=new ClassWriter(0);
				cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class"+i, null, "java/lang/Object", null);
				byte[] code=cw.toByteArray();
				t.defineClass("class"+i,code, 0, code.length);
			}
			
		}finally{
			System.out.println(j);
		}
	}
}
