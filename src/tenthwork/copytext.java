package tenthwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
 import org.junit.Test;
public class copytext {
	public void copy(String url1, String url2, String newfileName) throws Exception {
		File file = new File(url1);
		File copyFile = null;
		if (file.exists()) {
			copyFile = new File(url2);
			if (!copyFile.exists()) {
				copyFile.mkdirs();
			}
			Date date=new Date();		
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			String format = sdf.format(date);
			newfileName=format+".csv";
			FileInputStream in = new FileInputStream(new File(url1));
			FileOutputStream out = new FileOutputStream(new File(url2 + "\\" + newfileName));
			byte[] buff = new byte[512];
			int n = 0;
			System.out.println("复制文件：\n源路径：" + url1 + "\n" + "目标路径：" + url2 + "\\" + newfileName);
			while ((n = in.read(buff)) != -1) {
				out.write(buff, 0, n);
			}
			out.flush();
			in.close();
			out.close();
			System.out.println("复制完成");
		} else {
			System.out.println("源文件不存在");
		}
	}

}
