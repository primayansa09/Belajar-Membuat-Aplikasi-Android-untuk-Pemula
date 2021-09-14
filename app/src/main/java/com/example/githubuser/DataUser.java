package com.example.githubuser;

import java.util.ArrayList;

class DataUser {
    private static String[] nameuser = {
            "Jake Wharton",
            "AMIT SHEKHAR",
            "Romain Guy",
            "Chris Banes",
            "David",
            "Ravi Tamada",
            "Deny Prasetyo",
            "Budi Oktaviyan",
            "Hendi Santika",
            "Sidiq Permana"
    };

    private static String[] userName = {
            "JakeWharton",
            "amitshekhariitbhu",
            "romainguy",
            "chrisbanes",
            "tipsy",
            "ravi8x",
            "jasoet",
            "budioktaviyan",
            "hendisantika",
            "sidiqpermana",
    };

    private static String[] companyUser = {
            "Google, Inc.",
            "MindOrksOpenSource",
            "Google",
            "Google working on @andro",
            "Working Group Two",
            "AndroidHive | Droid5",
            "gojek-engineering",
            "KotlinID",
            "JVMDeveloperID @KotlinID @IDDevOps",
            "Nusantara Beta Studio"
    };

    private static String[] locationUser = {
            "Pittsburgh, PA, USA",
            "New Delhi, India",
            "California",
            "Sydney, Australia",
            "Trondheim, Norway",
            "India",
            "Kotagede, Yogyakarta, Indonesia",
            "Jakarta, Indonesia",
            "Bojongsoang - Bandung Jawa Barat",
            "Jakarta Indonesia"
    };

    private static String[] repositoryUser = {
            "102",
            "37",
            "9",
            "30",
            "56",
            "28",
            "44",
            "110",
            "1064",
            "65"
    };

    private static String[] followerUser = {
            "56995",
            "5153",
            "7972",
            "14725",
            "788",
            "18628",
            "277",
            "178",
            "428",
            "465"
    };

    private static String[] followingUser = {
            "12",
            "2",
            "0",
            "1",
            "0",
            "3",
            "39",
            "23",
            "61",
            "10"
    };

    private static int[] imgUser = {
            R.drawable.jakeharton,
            R.drawable.amitshekhariitbhu,
            R.drawable.romainguy,
            R.drawable.chrisbanes,
            R.drawable.tipsy,
            R.drawable.ravix,
            R.drawable.jasoet,
            R.drawable.budioktaviyan,
            R.drawable.hendisantika,
            R.drawable.sidiqpermana
    };

    static ArrayList<User> getListData(){
    ArrayList<User> list = new ArrayList<>();
    for (int i = 0; i < nameuser.length; i++){
        User user = new User();
        user.setNamaUser(nameuser[i]);
        user.setUsername(userName[i]);
        user.setCompanyUser(companyUser[i]);
        user.setLocationUser(locationUser[i]);
        user.setRepositoryUser(repositoryUser[i]);
        user.setFollowerUser(followerUser[i]);
        user.setFollowingUser(followingUser[i]);
        user.setPhotoUser(imgUser[i]);
        list.add(user);
    }
    return list;
    }
}
