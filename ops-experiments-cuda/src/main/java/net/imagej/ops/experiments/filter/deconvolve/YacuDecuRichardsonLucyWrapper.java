
package net.imagej.ops.experiments.filter.deconvolve;

import org.bytedeco.javacpp.FloatPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(value = { @Platform(include = "deconv.h", link = { "YacuDecu",
	"cudart", "cufft" }), @Platform(value = "windows-x86_64", linkpath = {
		"C:/Program Files/NVIDIA GPU Computing Toolkit/CUDA/v10.0/lib/x64/" }),
	@Platform(value = "linux-x86_64",
		includepath = "/usr/local/cuda-9.0/include/", linkpath = {
			"/usr/local/cuda-9.0/lib64/" }) })
public class YacuDecuRichardsonLucyWrapper {

	static {
		Loader.load();
	}

	public static native void deconv_device(int iter, int n1, int n2, int n3,
		FloatPointer image, FloatPointer psf, FloatPointer object,
		FloatPointer normal);

	public static native void conv_device(int n1, int n2, int n3,
		FloatPointer image, FloatPointer psf, FloatPointer out, int correlate);
	
	public static native void setDevice(int device); 

	public static void load() {
		Loader.load();
	};

}
