let userScore=0;
let computerScore=0;
const userScore_span=document.getElementById("user-score");
const computerScore_span=document.getElementById("comp-score");
const scoreBoard_div=document.querySelector(".score-board");
const resultDiv=document.querySelector(".result>p");
const rock_Div=document.getElementById("r");
const paper_Div=document.getElementById("p");
const scissor_Div=document.getElementById("s");

//conversion function()
function conversion(choice){
    if(choice==="r")return "Rock";
    else if(choice==="p") return "Paper";
    else return "Scissor";


}
//random function
function randomChoice(){
    const choice=['r','p','s'];
    const comprandNum=Math.floor(Math.random()*3);
    return choice[comprandNum];
}

//win lose and draw functions

function win(userChoice,compChoice){
    console.log("User wins");
    userScore++;
    userScore_span.innerHTML=userScore;
    console.log(userScore);
    document.getElementById(userChoice).classList.add('green-glow');
    resultDiv.innerHTML=`${conversion(userChoice)} beats ${conversion(compChoice)}, You win! &#128293;`;
    setTimeout(()=>document.getElementById(userChoice).classList.remove('green-glow'),300);
}

function lose(userChoice,compChoice){
    console.log("User lose");
    computerScore++;
    computerScore_span.innerHTML=computerScore;
    console.log(computerScore);
    document.getElementById(userChoice).classList.add('red-glow');
    resultDiv.innerHTML=`${conversion(userChoice)} does not beats  ${conversion(compChoice)}, You Lose &#128169;`;
    setTimeout(()=>document.getElementById(userChoice).classList.remove('red-glow'),300);
}

function draw(userChoice,compChoice){
    console.log("DRAW");
    document.getElementById(userChoice).classList.add('yellow-glow');
    resultDiv.innerHTML=`${conversion(userChoice)} equals ${conversion(compChoice)}, It's a draw &#128528;`;
    setTimeout(()=>document.getElementById(userChoice).classList.remove('yellow-glow'),300);
}









//game function
function game(userChoice){
    console.log("poop"+userChoice);
    const compChoice=randomChoice();
    console.log(compChoice);
    switch(userChoice+compChoice){
        case "rp":
        case "ps":
        case "sr":
            lose(userChoice,compChoice);
            break;
        case "pr":
        case "sp":
        case "rs":
            win(userChoice,compChoice);
            break;
        case "rr":
        case "pp":
        case "ss":
            draw(userChoice,compChoice);
            break;

    }

}


function main(){
    rock_Div.addEventListener('click',function(){
        game("r")
        console.log("clicked on rock");
    })

    paper_Div.addEventListener('click',function(){
        game("p");
        console.log("clicked on paper");
    })

    scissor_Div.addEventListener('click',function(){
        game("s");
        console.log("clicked on scissor");
    })
}
main();