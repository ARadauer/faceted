// Generated using typescript-generator version 1.19.294 on 2017-04-05 13:12:48.

export interface QuizResult {

    message:string;
    user:string;
    finished:boolean;
    started:boolean;

    currentQuestion:number;
    numberOfQuestions:number
    question:string;
    answers:Answer[];
    timeInSeconds:number;
    points:number;
}

export interface Answer {
    number:number;
    answer:string;
}

export interface ResultTo {
    num:number;
    name:string;
    points:number;
    time:number;
}

