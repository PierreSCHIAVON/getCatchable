export interface Catchable{
    id : number;
    name : string;
    icon : string;
    sell_price : number;
    time : string;
    month : string;
    type : CatchableType[];
}

export interface CatchableType{
    name : string;
}