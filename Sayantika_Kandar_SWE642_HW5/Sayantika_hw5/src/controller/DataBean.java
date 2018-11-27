/*NAME: SAYANTIKA KANDAR
This class initializes mean and standard deviation values
*/
package controller;
public class DataBean 
{
	private float mean;
	private float deviation;

	DataBean()
	{
		mean=0;
		deviation=0;
	}

	DataBean(float mean, float stddev)
	{
		this.mean=mean;
		this.deviation=stddev;
	}

	public float getMean() 
	{
		return mean;
	}

	public float getDeviation() 
	{
		return deviation;
	}
}
