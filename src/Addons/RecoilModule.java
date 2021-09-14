package me.nosaj9.CSaddons;

public class RecoilModule {
	
	private float yawValue;
	private float pitchValue;
	
	public RecoilModule(float y, float p) {
		yawValue = y;
		pitchValue = p;
	}
	
	public float getYaw() {
		return yawValue;
	}
	
	public float getPitch() {
		return pitchValue;
	}

}
