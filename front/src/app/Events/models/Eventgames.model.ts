import { User} from "./users.model"
import { Game} from "./Games.model"
export interface Eventgame{
    id_eventgame:Number,
    description:String,
    image:String,
    limitparticipants:Number,
    participants:Number,
    publicationevent:Date,
    title:String,
    id_game:Game,
    id_user:User| null | '';
}
