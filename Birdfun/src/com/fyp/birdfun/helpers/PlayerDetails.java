package com.fyp.birdfun.helpers;

import android.os.Parcel;
import android.os.Parcelable;

/*This to hold the player details pulled from database */
public class PlayerDetails implements Parcelable  {

	public int Pid=0;
	public String Name="birdfun";
	public int Total=0;
	// No-arg Ctor
	
	public PlayerDetails(){}	 
	 
	public PlayerDetails(Parcel in)
	    {
		 	this.Pid = in.readInt();
	        this.Name = in.readString();
	        this.Total = in.readInt();
	    }
	
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flag) {
		// TODO Auto-generated method stub
			dest.writeInt(Pid);
	        dest.writeString(Name);
	        dest.writeInt(Total);
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		public PlayerDetails createFromParcel(Parcel in)
	    {return new PlayerDetails(in);}
	 
	    public PlayerDetails[] newArray(int size)
	    {return new PlayerDetails[size];}
	    
	};
 
	
}