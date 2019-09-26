package nio.basic.buffer.model;

import java.nio.IntBuffer;

public class BufferModelDemo {

    public static void main(String[] args) {
        //第一步，获取IntBuffer，通过IntBuffer.allocate操作
        IntBuffer buf = IntBuffer.allocate(10) ;    // 准备出10个大小的缓冲区

        //第二步未操作前输出属性值
        System.out.println("position = " + buf.position() + "，limit = " + buf.limit() + "，capacty = " + buf.capacity()) ;

        //第三步进行设置数据
        buf.put(6) ;    // 设置一个数据
        buf.put(16) ;    // 设置二个数据

        //第四步操作后输出属性值
        System.out.println("position = " + buf.position() + "，limit = " + buf.limit() + "，capacty = " + buf.capacity()) ;

        //第五步将Buffer从写模式切换到读模式 postion = 0 ,limit = 原本position
        buf.flip() ;

        //第六步操作后输出属性值
        System.out.println("position = " + buf.position() + "，limit = " + buf.limit() + "，capacty = " + buf.capacity()) ;
    }

}
