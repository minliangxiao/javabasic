package club.huangliang.interview.reflect;

import java.io.*;

/*
* 这是用做演示自定义classLoader的例子
* */
public class MyClassLoader extends ClassLoader {
    private String path;
    private String classLoaderName;

    public MyClassLoader(String path,String classLoaderName){
        this.classLoaderName=classLoaderName;
        this.path=path;
    }
    //寻找文件类
    @Override
    public Class findClass(String name){
        byte[] b= new byte[0];
        try {
            b = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name,b,0,b.length);
    }
    //用于加载类文件
    private byte[] loadClassData(String name) throws IOException {
        name=path+name+".class";
        InputStream is=null;
        //接受byte类型的数据
        ByteArrayOutputStream out=null;
        try {
            //将name路径下的文件读取下来并转换成byte类型的输出流
            is= new FileInputStream(new File(name));
            out=new ByteArrayOutputStream();
            int i=0;
            while ((i=is.read())!=-1){
                //将is里面读取到的class字节码写入到ByteArrayOutStream里面
                out.write(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (is!=null){
                is.close();
            }
            if (out!=null){
                out.close();
            }


        }
        return out.toByteArray();
    }

}
