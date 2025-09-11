import fs from 'fs';
import readline from 'readline';

const ENCODING = {
    'y': 'a',
    'h': 'b',
    'v': 'c',
    'x': 'd',
    'k': 'e',
    'p': 'f',
    'z': 'g',
    's': 'h',
    'a': 'i',
    'b': 'j',
    'e': 'k',
    'w': 'l',
    'u': 'm',
    'q': 'n',
    'n': 'o',
    'l': 'p',
    'm': 'q',
    'f': 'r',
    'o': 's',
    'i': 't',
    'g': 'u',
    'j': 'v',
    't': 'w',
    'd': 'x',
    'r': 'y',
    'c': 'z',
    '3': '0',
    '8': '1',
    '4': '2',
    '0': '3',
    '2': '4',
    '7': '5',
    '5': '6',
    '9': '7',
    '1': '8',
    '6': '9'
}

export const decodeString = (encodedString) => {
    // returns encoded value or the input, if no matching value
    return encodedString.split('').map(l => ENCODING[l] || l).join('')
}

export const decodeIngredient = (ingredient, returnType = 'object') => {
    const decoded = decodeString(ingredient);
    // split by # to extract the units and description name
    const [amount, description] = decoded.split('#');
    if (returnType === 'object') return {
        amount,
        description,
    }

    return `${amount} ${description}`
};

export const decodeRecipe = async (filePath = 'secret_recipe.txt') => {
    const outputPath = 'decoded_recipe.txt';

    return new Promise((resolve, reject) => {
        let decoded = '';
        // read file
        const rl = readline.createInterface({
            input: fs.createReadStream(filePath),
            output: process.stdout,
            terminal: false
        });

        rl.on('line', (line) => {
            decoded += decodeIngredient(line, 'str') + '\n';
        });

        rl.on('close', async () => {
            // outputs to file   
            await fs.writeFile(outputPath, decoded, (err) => {
                if (err) {
                    console.error('Error writing file:', err);
                    return;
                }
                console.log(`File created: ${outputPath}`);
            });
            return resolve(decoded);
        });
    })
}

