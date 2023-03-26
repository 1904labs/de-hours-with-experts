//a similar program in javascript

const input = require('readline-sync');

let scrabble = {
    name: 'Scrabble', 
    description: 'The traditional scoring algorithm',
    scoreFunction: scrabbleScoreFunction}
  
let simpleScore = {
    name: 'Simple score',
    description: 'Each letter is worth 1 point',
    scoreFunction:  simpleScoreFunction}

let bonusVowels = {
   name: 'Bonus vowels',
   description: 'Vowels are 3 pts, consonants are 1 pt',
   scoreFunction: bonusVowelsFunction}

let scoringAlgorithms = [scrabble,simpleScore,bonusVowels];

function initialPrompt(){
  console.log("Welcome to the Scrabble score calculator!"+"\n"+"Enter 'Stop' to quit.");
  let userSelection = input.question('\n'+'Which scoring algorithm would you like to use? '+'\n'+'\n'+' 0 - Scrabble: The traditional scoring algorithm. '+'\n'+' 1 - Simple Score: Each letter is worth 1 point. '+'\n'+' 2 - Bonus Vowels: Vowels are worth 3 pts, and consonants are 1 pt. '+'\n'+'\n'+'Enter 0, 1, or 2:')

  return userSelection;
  }

const oldPointStructure = {
   1: ['A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'],
   2: ['D', 'G'],
   3: ['B', 'C', 'M', 'P'],
   4: ['F', 'H', 'V', 'W', 'Y'],
   5: ['K'],
   8: ['J', 'X'],
   10: ['Q', 'Z']
};

//Use the transform function to create the newPointStructure object here:
let newPointStructure = {};

function transform(object){
  for (key in object){ 
     for(let i=0;i<object[key].length;i++){
      newPointStructure[object[key][i].toLowerCase()]=Number(key);
    }
  }
   return newPointStructure
}
  
transform(oldPointStructure);

function runProgram(array){ 
  let scoreType=initialPrompt();
  let endProgram='stop';
  let endProgram1='Stop';
  //endProgram=endProgram.toLowerCase();
      
    while(scoreType!==endProgram && scoreType!==endProgram1){ 
        console.log("using algorithm:",scoringAlgorithms[scoreType].name);  
        let userWord = input.question('Enter a word to be scored: ');
        if(userWord!==endProgram && userWord!==endProgram1){
            if(scoreType==='1'){
              score1=scoringAlgorithms[scoreType].scoreFunction(userWord);
              console.log(`Score for '${userWord}': ${score1}`);
           }else if(scoreType==='2'){
             score2=scoringAlgorithms[scoreType].scoreFunction(userWord);     
             console.log(`Score for '${userWord}': ${score2}`);
           }else if(scoreType==='0'){
                score3=scoringAlgorithms[scoreType].scoreFunction(userWord,newPointStructure);
                console.log(`Score for '${userWord}': ${score3}`);
           }
        }else{
          break
        }
    }
    return
  }

runProgram(scoringAlgorithms);

function scrabbleScoreFunction(userWord,obj){  
  let score=0;
    userWord=userWord.toLowerCase();
      for(let i=0;i<userWord.length;i++){
          score+=obj[userWord[i]];
      }
  return score;
} 

function simpleScoreFunction(userWord){
  let score=userWord.length;
  return score;
}

function bonusVowelsFunction(userWord){  
  let score=0;
  userWord=userWord.toLowerCase();
  let vowels = ['a','e','i','o','u'];
    for(let i=0;i<userWord.length;i++){
        if(vowels.includes(userWord[i])){ 
          score+=3;
        }else{
          score+=1;
        }
      } return score;
    }

