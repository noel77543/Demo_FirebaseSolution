package tw.noel.sung.com.demo_firebasesolution.talk.list.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by noel on 2019/1/14.
 */
public class Talk {


    /**
     * rooms : {"ZZZ":{"agent":"BBB","guest":"CCC","host":"AAA","board":[{"id":"AAA","message":"哈囉你好嗎","name":"A先生","time":"2019.01.14  16:30"},{"id":"BBB","message":"衷心感謝","name":"B先生","time":"2019.01.14  16:30"},{"id":"CCC","message":"期待再相逢","name":"C先生","time":"2019.01.14  16:30"}]},"YYY":{"agent":"CCC","guest":"AAA","host":"BBB","board":[{"id":"AAA","message":"哈囉你好嗎","name":"A先生","time":"2019.01.14  16:30"},{"id":"BBB","message":"衷心感謝","name":"B先生","time":"2019.01.14  16:30"},{"id":"CCC","message":"期待再相逢","name":"C先生","time":"2019.01.14  16:30"}]},"XXX":{"agent":"AAA","guest":"BBB","host":"CCC","board":[{"id":"AAA","message":"哈囉你好嗎","name":"A先生","time":"2019.01.14  16:30"},{"id":"BBB","message":"衷心感謝","name":"B先生","time":"2019.01.14  16:30"},{"id":"CCC","message":"期待再相逢","name":"C先生","time":"2019.01.14  16:30"}]}}
     * users : {"AAA":{"name":"A先生","rooms":[{"isAgent":false,"isHolder":true,"roomId":"ZZZ"},{"isAgent":false,"isHolder":false,"roomId":"YYY"},{"isAgent":false,"isHolder":false,"roomId":"XXX"}]},"BBB":{"name":"B先生","rooms":[{"isAgent":true,"isHolder":false,"roomId":"ZZZ"},{"isAgent":false,"isHolder":true,"roomId":"YYY"},{"isAgent":false,"isHolder":false,"roomId":"XXX"}]},"CCC":{"name":"C先生","rooms":[{"isAgent":false,"isHolder":false,"roomId":"ZZZ"},{"isAgent":true,"isHolder":false,"roomId":"YYY"},{"isAgent":false,"isHolder":true,"roomId":"XXX"}]}}
     */

    @SerializedName("rooms")
    private RoomsBean rooms;
    @SerializedName("users")
    private UsersBean users;

    public RoomsBean getRooms() {
        return rooms;
    }

    public void setRooms(RoomsBean rooms) {
        this.rooms = rooms;
    }

    public UsersBean getUsers() {
        return users;
    }

    public void setUsers(UsersBean users) {
        this.users = users;
    }

    public static class RoomsBean {
        /**
         * ZZZ : {"agent":"BBB","guest":"CCC","host":"AAA","board":[{"id":"AAA","message":"哈囉你好嗎","name":"A先生","time":"2019.01.14  16:30"},{"id":"BBB","message":"衷心感謝","name":"B先生","time":"2019.01.14  16:30"},{"id":"CCC","message":"期待再相逢","name":"C先生","time":"2019.01.14  16:30"}]}
         * YYY : {"agent":"CCC","guest":"AAA","host":"BBB","board":[{"id":"AAA","message":"哈囉你好嗎","name":"A先生","time":"2019.01.14  16:30"},{"id":"BBB","message":"衷心感謝","name":"B先生","time":"2019.01.14  16:30"},{"id":"CCC","message":"期待再相逢","name":"C先生","time":"2019.01.14  16:30"}]}
         * XXX : {"agent":"AAA","guest":"BBB","host":"CCC","board":[{"id":"AAA","message":"哈囉你好嗎","name":"A先生","time":"2019.01.14  16:30"},{"id":"BBB","message":"衷心感謝","name":"B先生","time":"2019.01.14  16:30"},{"id":"CCC","message":"期待再相逢","name":"C先生","time":"2019.01.14  16:30"}]}
         */

        @SerializedName("ZZZ")
        private ZZZBean ZZZ;
        @SerializedName("YYY")
        private YYYBean YYY;
        @SerializedName("XXX")
        private XXXBean XXX;

        public ZZZBean getZZZ() {
            return ZZZ;
        }

        public void setZZZ(ZZZBean ZZZ) {
            this.ZZZ = ZZZ;
        }

        public YYYBean getYYY() {
            return YYY;
        }

        public void setYYY(YYYBean YYY) {
            this.YYY = YYY;
        }

        public XXXBean getXXX() {
            return XXX;
        }

        public void setXXX(XXXBean XXX) {
            this.XXX = XXX;
        }

        public static class ZZZBean {
            /**
             * agent : BBB
             * guest : CCC
             * host : AAA
             * board : [{"id":"AAA","message":"哈囉你好嗎","name":"A先生","time":"2019.01.14  16:30"},{"id":"BBB","message":"衷心感謝","name":"B先生","time":"2019.01.14  16:30"},{"id":"CCC","message":"期待再相逢","name":"C先生","time":"2019.01.14  16:30"}]
             */

            @SerializedName("agent")
            private String agent;
            @SerializedName("guest")
            private String guest;
            @SerializedName("host")
            private String host;
            @SerializedName("board")
            private List<BoardBean> board;

            public String getAgent() {
                return agent;
            }

            public void setAgent(String agent) {
                this.agent = agent;
            }

            public String getGuest() {
                return guest;
            }

            public void setGuest(String guest) {
                this.guest = guest;
            }

            public String getHost() {
                return host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public List<BoardBean> getBoard() {
                return board;
            }

            public void setBoard(List<BoardBean> board) {
                this.board = board;
            }

            public static class BoardBean {
                /**
                 * id : AAA
                 * message : 哈囉你好嗎
                 * name : A先生
                 * time : 2019.01.14  16:30
                 */

                @SerializedName("id")
                private String id;
                @SerializedName("message")
                private String message;
                @SerializedName("name")
                private String name;
                @SerializedName("time")
                private String time;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getMessage() {
                    return message;
                }

                public void setMessage(String message) {
                    this.message = message;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }
            }
        }

        public static class YYYBean {
            /**
             * agent : CCC
             * guest : AAA
             * host : BBB
             * board : [{"id":"AAA","message":"哈囉你好嗎","name":"A先生","time":"2019.01.14  16:30"},{"id":"BBB","message":"衷心感謝","name":"B先生","time":"2019.01.14  16:30"},{"id":"CCC","message":"期待再相逢","name":"C先生","time":"2019.01.14  16:30"}]
             */

            @SerializedName("agent")
            private String agent;
            @SerializedName("guest")
            private String guest;
            @SerializedName("host")
            private String host;
            @SerializedName("board")
            private List<BoardBeanX> board;

            public String getAgent() {
                return agent;
            }

            public void setAgent(String agent) {
                this.agent = agent;
            }

            public String getGuest() {
                return guest;
            }

            public void setGuest(String guest) {
                this.guest = guest;
            }

            public String getHost() {
                return host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public List<BoardBeanX> getBoard() {
                return board;
            }

            public void setBoard(List<BoardBeanX> board) {
                this.board = board;
            }

            public static class BoardBeanX {
                /**
                 * id : AAA
                 * message : 哈囉你好嗎
                 * name : A先生
                 * time : 2019.01.14  16:30
                 */

                @SerializedName("id")
                private String id;
                @SerializedName("message")
                private String message;
                @SerializedName("name")
                private String name;
                @SerializedName("time")
                private String time;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getMessage() {
                    return message;
                }

                public void setMessage(String message) {
                    this.message = message;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }
            }
        }

        public static class XXXBean {
            /**
             * agent : AAA
             * guest : BBB
             * host : CCC
             * board : [{"id":"AAA","message":"哈囉你好嗎","name":"A先生","time":"2019.01.14  16:30"},{"id":"BBB","message":"衷心感謝","name":"B先生","time":"2019.01.14  16:30"},{"id":"CCC","message":"期待再相逢","name":"C先生","time":"2019.01.14  16:30"}]
             */

            @SerializedName("agent")
            private String agent;
            @SerializedName("guest")
            private String guest;
            @SerializedName("host")
            private String host;
            @SerializedName("board")
            private List<BoardBeanXX> board;

            public String getAgent() {
                return agent;
            }

            public void setAgent(String agent) {
                this.agent = agent;
            }

            public String getGuest() {
                return guest;
            }

            public void setGuest(String guest) {
                this.guest = guest;
            }

            public String getHost() {
                return host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public List<BoardBeanXX> getBoard() {
                return board;
            }

            public void setBoard(List<BoardBeanXX> board) {
                this.board = board;
            }

            public static class BoardBeanXX {
                /**
                 * id : AAA
                 * message : 哈囉你好嗎
                 * name : A先生
                 * time : 2019.01.14  16:30
                 */

                @SerializedName("id")
                private String id;
                @SerializedName("message")
                private String message;
                @SerializedName("name")
                private String name;
                @SerializedName("time")
                private String time;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getMessage() {
                    return message;
                }

                public void setMessage(String message) {
                    this.message = message;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }
            }
        }
    }

    public static class UsersBean {
        /**
         * AAA : {"name":"A先生","rooms":[{"isAgent":false,"isHolder":true,"roomId":"ZZZ"},{"isAgent":false,"isHolder":false,"roomId":"YYY"},{"isAgent":false,"isHolder":false,"roomId":"XXX"}]}
         * BBB : {"name":"B先生","rooms":[{"isAgent":true,"isHolder":false,"roomId":"ZZZ"},{"isAgent":false,"isHolder":true,"roomId":"YYY"},{"isAgent":false,"isHolder":false,"roomId":"XXX"}]}
         * CCC : {"name":"C先生","rooms":[{"isAgent":false,"isHolder":false,"roomId":"ZZZ"},{"isAgent":true,"isHolder":false,"roomId":"YYY"},{"isAgent":false,"isHolder":true,"roomId":"XXX"}]}
         */

        @SerializedName("AAA")
        private AAABean AAA;
        @SerializedName("BBB")
        private BBBBean BBB;
        @SerializedName("CCC")
        private CCCBean CCC;

        public AAABean getAAA() {
            return AAA;
        }

        public void setAAA(AAABean AAA) {
            this.AAA = AAA;
        }

        public BBBBean getBBB() {
            return BBB;
        }

        public void setBBB(BBBBean BBB) {
            this.BBB = BBB;
        }

        public CCCBean getCCC() {
            return CCC;
        }

        public void setCCC(CCCBean CCC) {
            this.CCC = CCC;
        }

        public static class AAABean {
            /**
             * name : A先生
             * rooms : [{"isAgent":false,"isHolder":true,"roomId":"ZZZ"},{"isAgent":false,"isHolder":false,"roomId":"YYY"},{"isAgent":false,"isHolder":false,"roomId":"XXX"}]
             */

            @SerializedName("name")
            private String name;
            @SerializedName("rooms")
            private List<RoomsBeanX> rooms;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<RoomsBeanX> getRooms() {
                return rooms;
            }

            public void setRooms(List<RoomsBeanX> rooms) {
                this.rooms = rooms;
            }

            public static class RoomsBeanX {
                /**
                 * isAgent : false
                 * isHolder : true
                 * roomId : ZZZ
                 */

                @SerializedName("isAgent")
                private boolean isAgent;
                @SerializedName("isHolder")
                private boolean isHolder;
                @SerializedName("roomId")
                private String roomId;

                public boolean isIsAgent() {
                    return isAgent;
                }

                public void setIsAgent(boolean isAgent) {
                    this.isAgent = isAgent;
                }

                public boolean isIsHolder() {
                    return isHolder;
                }

                public void setIsHolder(boolean isHolder) {
                    this.isHolder = isHolder;
                }

                public String getRoomId() {
                    return roomId;
                }

                public void setRoomId(String roomId) {
                    this.roomId = roomId;
                }
            }
        }

        public static class BBBBean {
            /**
             * name : B先生
             * rooms : [{"isAgent":true,"isHolder":false,"roomId":"ZZZ"},{"isAgent":false,"isHolder":true,"roomId":"YYY"},{"isAgent":false,"isHolder":false,"roomId":"XXX"}]
             */

            @SerializedName("name")
            private String name;
            @SerializedName("rooms")
            private List<RoomsBeanXX> rooms;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<RoomsBeanXX> getRooms() {
                return rooms;
            }

            public void setRooms(List<RoomsBeanXX> rooms) {
                this.rooms = rooms;
            }

            public static class RoomsBeanXX {
                /**
                 * isAgent : true
                 * isHolder : false
                 * roomId : ZZZ
                 */

                @SerializedName("isAgent")
                private boolean isAgent;
                @SerializedName("isHolder")
                private boolean isHolder;
                @SerializedName("roomId")
                private String roomId;

                public boolean isIsAgent() {
                    return isAgent;
                }

                public void setIsAgent(boolean isAgent) {
                    this.isAgent = isAgent;
                }

                public boolean isIsHolder() {
                    return isHolder;
                }

                public void setIsHolder(boolean isHolder) {
                    this.isHolder = isHolder;
                }

                public String getRoomId() {
                    return roomId;
                }

                public void setRoomId(String roomId) {
                    this.roomId = roomId;
                }
            }
        }

        public static class CCCBean {
            /**
             * name : C先生
             * rooms : [{"isAgent":false,"isHolder":false,"roomId":"ZZZ"},{"isAgent":true,"isHolder":false,"roomId":"YYY"},{"isAgent":false,"isHolder":true,"roomId":"XXX"}]
             */

            @SerializedName("name")
            private String name;
            @SerializedName("rooms")
            private List<RoomsBeanXXX> rooms;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<RoomsBeanXXX> getRooms() {
                return rooms;
            }

            public void setRooms(List<RoomsBeanXXX> rooms) {
                this.rooms = rooms;
            }

            public static class RoomsBeanXXX {
                /**
                 * isAgent : false
                 * isHolder : false
                 * roomId : ZZZ
                 */

                @SerializedName("isAgent")
                private boolean isAgent;
                @SerializedName("isHolder")
                private boolean isHolder;
                @SerializedName("roomId")
                private String roomId;

                public boolean isIsAgent() {
                    return isAgent;
                }

                public void setIsAgent(boolean isAgent) {
                    this.isAgent = isAgent;
                }

                public boolean isIsHolder() {
                    return isHolder;
                }

                public void setIsHolder(boolean isHolder) {
                    this.isHolder = isHolder;
                }

                public String getRoomId() {
                    return roomId;
                }

                public void setRoomId(String roomId) {
                    this.roomId = roomId;
                }
            }
        }
    }
}
