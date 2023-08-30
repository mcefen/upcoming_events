import { User} from "./users.model"
import { Game} from "./Games.model"
export interface Eventgame{
    id_eventgame:Number,
    description:string,
    image:string,
    limitparticipants:Number,
    participants:Number,
    publicationevent:string,
    title:string,
    id_game:Number,
    id_user:User| null |undefined| '';
}
