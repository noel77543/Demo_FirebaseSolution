package tw.noel.sung.com.demo_firebasesolution.talk.list.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    /**
     * name : A先生
     * rooms : [{"isAgent":false,"isHolder":true,"roomId":"ZZZ"},{"isAgent":false,"isHolder":false,"roomId":"YYY"},{"isAgent":false,"isHolder":false,"roomId":"XXX"}]
     */

    @SerializedName("name")
    private String name;
    @SerializedName("rooms")
    private ArrayList<RoomsBean> rooms;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<RoomsBean> getRooms() {
        return rooms == null ? new ArrayList<RoomsBean>() : rooms;
    }

    public void setRooms(ArrayList<RoomsBean> rooms) {
        this.rooms = rooms;
    }

    public static class RoomsBean implements Parcelable {
        /**
         * type
         * roomId : ZZZ
         */


        @SerializedName("type")
        private int type;
        @SerializedName("roomId")
        private String roomId;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.type);
            dest.writeString(this.roomId);
        }

        public RoomsBean() {
        }

        protected RoomsBean(Parcel in) {
            this.type = in.readInt();
            this.roomId = in.readString();
        }

        public static final Parcelable.Creator<RoomsBean> CREATOR = new Parcelable.Creator<RoomsBean>() {
            @Override
            public RoomsBean createFromParcel(Parcel source) {
                return new RoomsBean(source);
            }

            @Override
            public RoomsBean[] newArray(int size) {
                return new RoomsBean[size];
            }
        };
    }


}
