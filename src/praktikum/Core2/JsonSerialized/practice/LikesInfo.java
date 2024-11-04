package praktikum.Core2.JsonSerialized.practice;

public class LikesInfo {
    private boolean hasOwnedLiked;
    private Like[] likes;
    private int repostsCount;
    private LastLikeInfo lastLikeInfo;

    public boolean isHasOwnerLiked() {
        return hasOwnedLiked;
    }

    public void setHasOwnerLiked(boolean hasOwnedLiked){
        this.hasOwnedLiked = hasOwnedLiked;
    }

    public Like[] getLikes() {
        return likes;
    }

    public void setLikes(Like[] likes) {
        this.likes = likes;
    }

    public int getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(int repostsCount) {
        this.repostsCount = repostsCount;
    }

    public LastLikeInfo getLastLikeInfo() {
        return lastLikeInfo;
    }

    public void setLastLikeInfo(LastLikeInfo lastLikeInfo) {
        this.lastLikeInfo = lastLikeInfo;
    }
}
