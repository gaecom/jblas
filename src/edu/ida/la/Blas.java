package edu.ida.la;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import edu.ida.core.ComplexFloat;
import edu.ida.core.ComplexDouble;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.lang.UnsatisfiedLinkError;

public class Blas {

  static {
	  try {
		  System.loadLibrary("jBlasArray");
	  }
	  catch(UnsatisfiedLinkError e) {
		  System.err.println(
				  "BLAS native library not found in path. Copying native library\n" +
				  "from the archive. Consider installing the library somewhere\n" +
				  "in the path (for Windows: PATH, for Linux: LD_LIBRARY_PATH).");
		  new edu.ida.core.LibraryLoader().loadLibrary("jBlasArray");
	  }
  } 

  public static native void caxpy(int n, ComplexFloat ca, float[] cx, int cxIdx, int incx, float[] cy, int cyIdx, int incy);
  public static native void ccopy(int n, float[] cx, int cxIdx, int incx, float[] cy, int cyIdx, int incy);
  public static native ComplexFloat cdotc(int n, float[] cx, int cxIdx, int incx, float[] cy, int cyIdx, int incy);
  public static native ComplexFloat cdotu(int n, float[] cx, int cxIdx, int incx, float[] cy, int cyIdx, int incy);
  public static native void cgbmv(char trans, int m, int n, int kl, int ku, ComplexFloat alpha, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx, ComplexFloat beta, float[] y, int yIdx, int incy);
  public static native void cgemm(char transa, char transb, int m, int n, int k, ComplexFloat alpha, float[] a, int aIdx, int lda, float[] b, int bIdx, int ldb, ComplexFloat beta, float[] c, int cIdx, int ldc);
  public static native void cgemv(char trans, int m, int n, ComplexFloat alpha, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx, ComplexFloat beta, float[] y, int yIdx, int incy);
  public static native void cgerc(int m, int n, ComplexFloat alpha, float[] x, int xIdx, int incx, float[] y, int yIdx, int incy, float[] a, int aIdx, int lda);
  public static native void cgeru(int m, int n, ComplexFloat alpha, float[] x, int xIdx, int incx, float[] y, int yIdx, int incy, float[] a, int aIdx, int lda);
  public static native void chbmv(char uplo, int n, int k, ComplexFloat alpha, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx, ComplexFloat beta, float[] y, int yIdx, int incy);
  public static native void chemm(char side, char uplo, int m, int n, ComplexFloat alpha, float[] a, int aIdx, int lda, float[] b, int bIdx, int ldb, ComplexFloat beta, float[] c, int cIdx, int ldc);
  public static native void chemv(char uplo, int n, ComplexFloat alpha, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx, ComplexFloat beta, float[] y, int yIdx, int incy);
  public static native void cher2(char uplo, int n, ComplexFloat alpha, float[] x, int xIdx, int incx, float[] y, int yIdx, int incy, float[] a, int aIdx, int lda);
  public static native void cher2k(char uplo, char trans, int n, int k, ComplexFloat alpha, float[] a, int aIdx, int lda, float[] b, int bIdx, int ldb, float beta, float[] c, int cIdx, int ldc);
  public static native void cher(char uplo, int n, float alpha, float[] x, int xIdx, int incx, float[] a, int aIdx, int lda);
  public static native void cherk(char uplo, char trans, int n, int k, float alpha, float[] a, int aIdx, int lda, float beta, float[] c, int cIdx, int ldc);
  public static native void chpmv(char uplo, int n, ComplexFloat alpha, float[] ap, int apIdx, float[] x, int xIdx, int incx, ComplexFloat beta, float[] y, int yIdx, int incy);
  public static native void chpr2(char uplo, int n, ComplexFloat alpha, float[] x, int xIdx, int incx, float[] y, int yIdx, int incy, float[] ap, int apIdx);
  public static native void chpr(char uplo, int n, float alpha, float[] x, int xIdx, int incx, float[] ap, int apIdx);
  public static native void crotg(ComplexFloat ca, ComplexFloat cb, float c, ComplexFloat s);
  public static native void cscal(int n, ComplexFloat ca, float[] cx, int cxIdx, int incx);
  public static native void csrot(int n, float[] cx, int cxIdx, int incx, float[] cy, int cyIdx, int incy, float c, float s);
  public static native void csscal(int n, float sa, float[] cx, int cxIdx, int incx);
  public static native void cswap(int n, float[] cx, int cxIdx, int incx, float[] cy, int cyIdx, int incy);
  public static native void csymm(char side, char uplo, int m, int n, ComplexFloat alpha, float[] a, int aIdx, int lda, float[] b, int bIdx, int ldb, ComplexFloat beta, float[] c, int cIdx, int ldc);
  public static native void csyr2k(char uplo, char trans, int n, int k, ComplexFloat alpha, float[] a, int aIdx, int lda, float[] b, int bIdx, int ldb, ComplexFloat beta, float[] c, int cIdx, int ldc);
  public static native void csyrk(char uplo, char trans, int n, int k, ComplexFloat alpha, float[] a, int aIdx, int lda, ComplexFloat beta, float[] c, int cIdx, int ldc);
  public static native void ctbmv(char uplo, char trans, char diag, int n, int k, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx);
  public static native void ctbsv(char uplo, char trans, char diag, int n, int k, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx);
  public static native void ctpmv(char uplo, char trans, char diag, int n, float[] ap, int apIdx, float[] x, int xIdx, int incx);
  public static native void ctpsv(char uplo, char trans, char diag, int n, float[] ap, int apIdx, float[] x, int xIdx, int incx);
  public static native void ctrmm(char side, char uplo, char transa, char diag, int m, int n, ComplexFloat alpha, float[] a, int aIdx, int lda, float[] b, int bIdx, int ldb);
  public static native void ctrmv(char uplo, char trans, char diag, int n, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx);
  public static native void ctrsm(char side, char uplo, char transa, char diag, int m, int n, ComplexFloat alpha, float[] a, int aIdx, int lda, float[] b, int bIdx, int ldb);
  public static native void ctrsv(char uplo, char trans, char diag, int n, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx);
  public static native double dasum(int n, double[] dx, int dxIdx, int incx);
  public static native void daxpy(int n, double da, double[] dx, int dxIdx, int incx, double[] dy, int dyIdx, int incy);
  public static native double dcabs1(ComplexDouble z);
  public static native void dcopy(int n, double[] dx, int dxIdx, int incx, double[] dy, int dyIdx, int incy);
  public static native double ddot(int n, double[] dx, int dxIdx, int incx, double[] dy, int dyIdx, int incy);
  public static native void dgbmv(char trans, int m, int n, int kl, int ku, double alpha, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx, double beta, double[] y, int yIdx, int incy);
  public static native void dgemm(char transa, char transb, int m, int n, int k, double alpha, double[] a, int aIdx, int lda, double[] b, int bIdx, int ldb, double beta, double[] c, int cIdx, int ldc);
  public static native void dgemv(char trans, int m, int n, double alpha, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx, double beta, double[] y, int yIdx, int incy);
  public static native void dger(int m, int n, double alpha, double[] x, int xIdx, int incx, double[] y, int yIdx, int incy, double[] a, int aIdx, int lda);
  public static native double dnrm2(int n, double[] x, int xIdx, int incx);
  public static native void drot(int n, double[] dx, int dxIdx, int incx, double[] dy, int dyIdx, int incy, double c, double s);
  public static native void drotg(double da, double db, double c, double s);
  public static native void drotm(int n, double[] dx, int dxIdx, int incx, double[] dy, int dyIdx, int incy, double[] dparam, int dparamIdx);
  public static native void drotmg(double dd1, double dd2, double dx1, double dy1, double[] dparam, int dparamIdx);
  public static native void dsbmv(char uplo, int n, int k, double alpha, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx, double beta, double[] y, int yIdx, int incy);
  public static native void dscal(int n, double da, double[] dx, int dxIdx, int incx);
  public static native double dsdot(int n, float[] sx, int sxIdx, int incx, float[] sy, int syIdx, int incy);
  public static native void dspmv(char uplo, int n, double alpha, double[] ap, int apIdx, double[] x, int xIdx, int incx, double beta, double[] y, int yIdx, int incy);
  public static native void dspr2(char uplo, int n, double alpha, double[] x, int xIdx, int incx, double[] y, int yIdx, int incy, double[] ap, int apIdx);
  public static native void dspr(char uplo, int n, double alpha, double[] x, int xIdx, int incx, double[] ap, int apIdx);
  public static native void dswap(int n, double[] dx, int dxIdx, int incx, double[] dy, int dyIdx, int incy);
  public static native void dsymm(char side, char uplo, int m, int n, double alpha, double[] a, int aIdx, int lda, double[] b, int bIdx, int ldb, double beta, double[] c, int cIdx, int ldc);
  public static native void dsymv(char uplo, int n, double alpha, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx, double beta, double[] y, int yIdx, int incy);
  public static native void dsyr2(char uplo, int n, double alpha, double[] x, int xIdx, int incx, double[] y, int yIdx, int incy, double[] a, int aIdx, int lda);
  public static native void dsyr2k(char uplo, char trans, int n, int k, double alpha, double[] a, int aIdx, int lda, double[] b, int bIdx, int ldb, double beta, double[] c, int cIdx, int ldc);
  public static native void dsyr(char uplo, int n, double alpha, double[] x, int xIdx, int incx, double[] a, int aIdx, int lda);
  public static native void dsyrk(char uplo, char trans, int n, int k, double alpha, double[] a, int aIdx, int lda, double beta, double[] c, int cIdx, int ldc);
  public static native void dtbmv(char uplo, char trans, char diag, int n, int k, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx);
  public static native void dtbsv(char uplo, char trans, char diag, int n, int k, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx);
  public static native void dtpmv(char uplo, char trans, char diag, int n, double[] ap, int apIdx, double[] x, int xIdx, int incx);
  public static native void dtpsv(char uplo, char trans, char diag, int n, double[] ap, int apIdx, double[] x, int xIdx, int incx);
  public static native void dtrmm(char side, char uplo, char transa, char diag, int m, int n, double alpha, double[] a, int aIdx, int lda, double[] b, int bIdx, int ldb);
  public static native void dtrmv(char uplo, char trans, char diag, int n, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx);
  public static native void dtrsm(char side, char uplo, char transa, char diag, int m, int n, double alpha, double[] a, int aIdx, int lda, double[] b, int bIdx, int ldb);
  public static native void dtrsv(char uplo, char trans, char diag, int n, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx);
  public static native double dzasum(int n, double[] zx, int zxIdx, int incx);
  public static native double dznrm2(int n, double[] x, int xIdx, int incx);
  public static native int icamax(int n, float[] cx, int cxIdx, int incx);
  public static native int idamax(int n, double[] dx, int dxIdx, int incx);
  public static native int isamax(int n, float[] sx, int sxIdx, int incx);
  public static native int izamax(int n, double[] zx, int zxIdx, int incx);
  public static native int lsame(char ca, char cb);
  public static native float sasum(int n, float[] sx, int sxIdx, int incx);
  public static native void saxpy(int n, float sa, float[] sx, int sxIdx, int incx, float[] sy, int syIdx, int incy);
  public static native float scasum(int n, float[] cx, int cxIdx, int incx);
  public static native float scnrm2(int n, float[] x, int xIdx, int incx);
  public static native void scopy(int n, float[] sx, int sxIdx, int incx, float[] sy, int syIdx, int incy);
  public static native float sdot(int n, float[] sx, int sxIdx, int incx, float[] sy, int syIdx, int incy);
  public static native float sdsdot(int n, float sb, float[] sx, int sxIdx, int incx, float[] sy, int syIdx, int incy);
  public static native void sgbmv(char trans, int m, int n, int kl, int ku, float alpha, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx, float beta, float[] y, int yIdx, int incy);
  public static native void sgemm(char transa, char transb, int m, int n, int k, float alpha, float[] a, int aIdx, int lda, float[] b, int bIdx, int ldb, float beta, float[] c, int cIdx, int ldc);
  public static native void sgemv(char trans, int m, int n, float alpha, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx, float beta, float[] y, int yIdx, int incy);
  public static native void sger(int m, int n, float alpha, float[] x, int xIdx, int incx, float[] y, int yIdx, int incy, float[] a, int aIdx, int lda);
  public static native float snrm2(int n, float[] x, int xIdx, int incx);
  public static native void srot(int n, float[] sx, int sxIdx, int incx, float[] sy, int syIdx, int incy, float c, float s);
  public static native void srotg(float sa, float sb, float c, float s);
  public static native void srotm(int n, float[] sx, int sxIdx, int incx, float[] sy, int syIdx, int incy, float[] sparam, int sparamIdx);
  public static native void srotmg(float sd1, float sd2, float sx1, float sy1, float[] sparam, int sparamIdx);
  public static native void ssbmv(char uplo, int n, int k, float alpha, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx, float beta, float[] y, int yIdx, int incy);
  public static native void sscal(int n, float sa, float[] sx, int sxIdx, int incx);
  public static native void sspmv(char uplo, int n, float alpha, float[] ap, int apIdx, float[] x, int xIdx, int incx, float beta, float[] y, int yIdx, int incy);
  public static native void sspr2(char uplo, int n, float alpha, float[] x, int xIdx, int incx, float[] y, int yIdx, int incy, float[] ap, int apIdx);
  public static native void sspr(char uplo, int n, float alpha, float[] x, int xIdx, int incx, float[] ap, int apIdx);
  public static native void sswap(int n, float[] sx, int sxIdx, int incx, float[] sy, int syIdx, int incy);
  public static native void ssymm(char side, char uplo, int m, int n, float alpha, float[] a, int aIdx, int lda, float[] b, int bIdx, int ldb, float beta, float[] c, int cIdx, int ldc);
  public static native void ssymv(char uplo, int n, float alpha, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx, float beta, float[] y, int yIdx, int incy);
  public static native void ssyr2(char uplo, int n, float alpha, float[] x, int xIdx, int incx, float[] y, int yIdx, int incy, float[] a, int aIdx, int lda);
  public static native void ssyr2k(char uplo, char trans, int n, int k, float alpha, float[] a, int aIdx, int lda, float[] b, int bIdx, int ldb, float beta, float[] c, int cIdx, int ldc);
  public static native void ssyr(char uplo, int n, float alpha, float[] x, int xIdx, int incx, float[] a, int aIdx, int lda);
  public static native void ssyrk(char uplo, char trans, int n, int k, float alpha, float[] a, int aIdx, int lda, float beta, float[] c, int cIdx, int ldc);
  public static native void stbmv(char uplo, char trans, char diag, int n, int k, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx);
  public static native void stbsv(char uplo, char trans, char diag, int n, int k, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx);
  public static native void stpmv(char uplo, char trans, char diag, int n, float[] ap, int apIdx, float[] x, int xIdx, int incx);
  public static native void stpsv(char uplo, char trans, char diag, int n, float[] ap, int apIdx, float[] x, int xIdx, int incx);
  public static native void strmm(char side, char uplo, char transa, char diag, int m, int n, float alpha, float[] a, int aIdx, int lda, float[] b, int bIdx, int ldb);
  public static native void strmv(char uplo, char trans, char diag, int n, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx);
  public static native void strsm(char side, char uplo, char transa, char diag, int m, int n, float alpha, float[] a, int aIdx, int lda, float[] b, int bIdx, int ldb);
  public static native void strsv(char uplo, char trans, char diag, int n, float[] a, int aIdx, int lda, float[] x, int xIdx, int incx);
  public static native void zaxpy(int n, ComplexDouble za, double[] zx, int zxIdx, int incx, double[] zy, int zyIdx, int incy);
  public static native void zcopy(int n, double[] zx, int zxIdx, int incx, double[] zy, int zyIdx, int incy);
  public static native ComplexDouble zdotc(int n, double[] zx, int zxIdx, int incx, double[] zy, int zyIdx, int incy);
  public static native ComplexDouble zdotu(int n, double[] zx, int zxIdx, int incx, double[] zy, int zyIdx, int incy);
  public static native void zdrot(int n, double[] cx, int cxIdx, int incx, double[] cy, int cyIdx, int incy, double c, double s);
  public static native void zdscal(int n, double da, double[] zx, int zxIdx, int incx);
  public static native void zgbmv(char trans, int m, int n, int kl, int ku, ComplexDouble alpha, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx, ComplexDouble beta, double[] y, int yIdx, int incy);
  public static native void zgemm(char transa, char transb, int m, int n, int k, ComplexDouble alpha, double[] a, int aIdx, int lda, double[] b, int bIdx, int ldb, ComplexDouble beta, double[] c, int cIdx, int ldc);
  public static native void zgemv(char trans, int m, int n, ComplexDouble alpha, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx, ComplexDouble beta, double[] y, int yIdx, int incy);
  public static native void zgerc(int m, int n, ComplexDouble alpha, double[] x, int xIdx, int incx, double[] y, int yIdx, int incy, double[] a, int aIdx, int lda);
  public static native void zgeru(int m, int n, ComplexDouble alpha, double[] x, int xIdx, int incx, double[] y, int yIdx, int incy, double[] a, int aIdx, int lda);
  public static native void zhbmv(char uplo, int n, int k, ComplexDouble alpha, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx, ComplexDouble beta, double[] y, int yIdx, int incy);
  public static native void zhemm(char side, char uplo, int m, int n, ComplexDouble alpha, double[] a, int aIdx, int lda, double[] b, int bIdx, int ldb, ComplexDouble beta, double[] c, int cIdx, int ldc);
  public static native void zhemv(char uplo, int n, ComplexDouble alpha, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx, ComplexDouble beta, double[] y, int yIdx, int incy);
  public static native void zher2(char uplo, int n, ComplexDouble alpha, double[] x, int xIdx, int incx, double[] y, int yIdx, int incy, double[] a, int aIdx, int lda);
  public static native void zher2k(char uplo, char trans, int n, int k, ComplexDouble alpha, double[] a, int aIdx, int lda, double[] b, int bIdx, int ldb, double beta, double[] c, int cIdx, int ldc);
  public static native void zher(char uplo, int n, double alpha, double[] x, int xIdx, int incx, double[] a, int aIdx, int lda);
  public static native void zherk(char uplo, char trans, int n, int k, double alpha, double[] a, int aIdx, int lda, double beta, double[] c, int cIdx, int ldc);
  public static native void zhpmv(char uplo, int n, ComplexDouble alpha, double[] ap, int apIdx, double[] x, int xIdx, int incx, ComplexDouble beta, double[] y, int yIdx, int incy);
  public static native void zhpr2(char uplo, int n, ComplexDouble alpha, double[] x, int xIdx, int incx, double[] y, int yIdx, int incy, double[] ap, int apIdx);
  public static native void zhpr(char uplo, int n, double alpha, double[] x, int xIdx, int incx, double[] ap, int apIdx);
  public static native void zrotg(ComplexDouble ca, ComplexDouble cb, double c, ComplexDouble s);
  public static native void zscal(int n, ComplexDouble za, double[] zx, int zxIdx, int incx);
  public static native void zswap(int n, double[] zx, int zxIdx, int incx, double[] zy, int zyIdx, int incy);
  public static native void zsymm(char side, char uplo, int m, int n, ComplexDouble alpha, double[] a, int aIdx, int lda, double[] b, int bIdx, int ldb, ComplexDouble beta, double[] c, int cIdx, int ldc);
  public static native void zsyr2k(char uplo, char trans, int n, int k, ComplexDouble alpha, double[] a, int aIdx, int lda, double[] b, int bIdx, int ldb, ComplexDouble beta, double[] c, int cIdx, int ldc);
  public static native void zsyrk(char uplo, char trans, int n, int k, ComplexDouble alpha, double[] a, int aIdx, int lda, ComplexDouble beta, double[] c, int cIdx, int ldc);
  public static native void ztbmv(char uplo, char trans, char diag, int n, int k, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx);
  public static native void ztbsv(char uplo, char trans, char diag, int n, int k, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx);
  public static native void ztpmv(char uplo, char trans, char diag, int n, double[] ap, int apIdx, double[] x, int xIdx, int incx);
  public static native void ztpsv(char uplo, char trans, char diag, int n, double[] ap, int apIdx, double[] x, int xIdx, int incx);
  public static native void ztrmm(char side, char uplo, char transa, char diag, int m, int n, ComplexDouble alpha, double[] a, int aIdx, int lda, double[] b, int bIdx, int ldb);
  public static native void ztrmv(char uplo, char trans, char diag, int n, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx);
  public static native void ztrsm(char side, char uplo, char transa, char diag, int m, int n, ComplexDouble alpha, double[] a, int aIdx, int lda, double[] b, int bIdx, int ldb);
  public static native void ztrsv(char uplo, char trans, char diag, int n, double[] a, int aIdx, int lda, double[] x, int xIdx, int incx);
  public static native int dgesv(int n, int nrhs, double[] a, int aIdx, int lda, int[] ipiv, int ipivIdx, double[] b, int bIdx, int ldb);
  public static native int sgesv(int n, int nrhs, float[] a, int aIdx, int lda, int[] ipiv, int ipivIdx, float[] b, int bIdx, int ldb);
  public static native int dsysv(char uplo, int n, int nrhs, double[] a, int aIdx, int lda, int[] ipiv, int ipivIdx, double[] b, int bIdx, int ldb, double[] work, int workIdx, int lwork);
  public static native int ssysv(char uplo, int n, int nrhs, float[] a, int aIdx, int lda, int[] ipiv, int ipivIdx, float[] b, int bIdx, int ldb, float[] work, int workIdx, int lwork);
  public static native int dsyev(char jobz, char uplo, int n, double[] a, int aIdx, int lda, double[] w, int wIdx, double[] work, int workIdx, int lwork);
  public static native int ssyev(char jobz, char uplo, int n, float[] a, int aIdx, int lda, float[] w, int wIdx, float[] work, int workIdx, int lwork);
  public static native int dsyevd(char jobz, char uplo, int n, double[] a, int aIdx, int lda, double[] w, int wIdx, double[] work, int workIdx, int lwork, int[] iwork, int iworkIdx, int liwork);
  public static native int dsyevr(char jobz, char range, char uplo, int n, double[] a, int aIdx, int lda, double vl, double vu, int il, int iu, double abstol, int m, double[] w, int wIdx, double[] z, int zIdx, int ldz, int[] isuppz, int isuppzIdx, double[] work, int workIdx, int lwork, int[] iwork, int iworkIdx, int liwork);
  public static native int dsyevx(char jobz, char range, char uplo, int n, double[] a, int aIdx, int lda, double vl, double vu, int il, int iu, double abstol, int m, double[] w, int wIdx, double[] z, int zIdx, int ldz, double[] work, int workIdx, int lwork, int[] iwork, int iworkIdx, int[] ifail, int ifailIdx);
  public static native int ssyevd(char jobz, char uplo, int n, float[] a, int aIdx, int lda, float[] w, int wIdx, float[] work, int workIdx, int lwork, int[] iwork, int iworkIdx, int liwork);
  public static native int ssyevr(char jobz, char range, char uplo, int n, float[] a, int aIdx, int lda, float vl, float vu, int il, int iu, float abstol, int m, float[] w, int wIdx, float[] z, int zIdx, int ldz, int[] isuppz, int isuppzIdx, float[] work, int workIdx, int lwork, int[] iwork, int iworkIdx, int liwork);
  public static native int ssyevx(char jobz, char range, char uplo, int n, float[] a, int aIdx, int lda, float vl, float vu, int il, int iu, float abstol, int m, float[] w, int wIdx, float[] z, int zIdx, int ldz, float[] work, int workIdx, int lwork, int[] iwork, int iworkIdx, int[] ifail, int ifailIdx);
  public static native int dposv(char uplo, int n, int nrhs, double[] a, int aIdx, int lda, double[] b, int bIdx, int ldb);
  public static native int sposv(char uplo, int n, int nrhs, float[] a, int aIdx, int lda, float[] b, int bIdx, int ldb);
  public static native int dgeev(char jobvl, char jobvr, int n, double[] a, int aIdx, int lda, double[] wr, int wrIdx, double[] wi, int wiIdx, double[] vl, int vlIdx, int ldvl, double[] vr, int vrIdx, int ldvr, double[] work, int workIdx, int lwork);
  public static native int sgeev(char jobvl, char jobvr, int n, float[] a, int aIdx, int lda, float[] wr, int wrIdx, float[] wi, int wiIdx, float[] vl, int vlIdx, int ldvl, float[] vr, int vrIdx, int ldvr, float[] work, int workIdx, int lwork);

}
