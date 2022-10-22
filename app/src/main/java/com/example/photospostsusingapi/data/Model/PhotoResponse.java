package com.example.photospostsusingapi.data.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PhotoResponse{

	@SerializedName("PhotoResponse")
	private List<PhotoResponseItem> photoResponse;

	public List<PhotoResponseItem> getPhotoResponse(){
		return photoResponse;
	}
}