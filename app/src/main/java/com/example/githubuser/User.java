package com.example.githubuser;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

class User extends ArrayList<Parcelable> implements Parcelable {
    private int photoUser;
    private String namaUser;
    private String username;
    private String companyUser;
    private String locationUser;
    private String repositoryUser;
    private String followerUser;
    private String followingUser;

    public User(){

    }

    protected User(Parcel in) {
        photoUser = in.readInt();
        namaUser = in.readString();
        username = in.readString();
        companyUser = in.readString();
        locationUser = in.readString();
        repositoryUser = in.readString();
        followerUser = in.readString();
        followingUser = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photoUser);
        dest.writeString(namaUser);
        dest.writeString(username);
        dest.writeString(companyUser);
        dest.writeString(locationUser);
        dest.writeString(repositoryUser);
        dest.writeString(followerUser);
        dest.writeString(followingUser);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getPhotoUser() {
        return photoUser;
    }

    public void setPhotoUser(int photoUser) {
        this.photoUser = photoUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(String companyUser) {
        this.companyUser = companyUser;
    }

    public String getLocationUser() {
        return locationUser;
    }

    public void setLocationUser(String locationUser) {
        this.locationUser = locationUser;
    }

    public String getRepositoryUser() {
        return repositoryUser;
    }

    public void setRepositoryUser(String repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public String getFollowerUser() {
        return followerUser;
    }

    public void setFollowerUser(String followerUser) {
        this.followerUser = followerUser;
    }

    public String getFollowingUser() {
        return followingUser;
    }

    public void setFollowingUser(String followingUser) {
        this.followingUser = followingUser;
    }
}
