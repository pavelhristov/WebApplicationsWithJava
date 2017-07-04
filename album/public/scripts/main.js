// CREATE  ALBUM

// $.ajax({
//     method: 'POST',
//     url: '/api/albums/create',
//     data: JSON.stringify({
//         name: 'trendafil'
//     }),
//     contentType: 'application/json',
//     dataType: 'json',
//     success: (res) => {
//         console.log(res);
//     },
//     error: (res) => {
//         console.log(res);
//     }
// })

// var myImage = document.getElementById('myimage');
// var myCanvas = document.getElementById('mycanvas');

// var ctx = myCanvas.getContext('2d');

// ctx.drawImage(myImage, 0, 0);

// var mydataURL=myCanvas.toDataURL('image/jpg');

// console.log(mydataURL);

// ==========================================
// ADD IMAGE

const toDataURL = url => fetch(url)
    .then(response => response.blob())
    .then(blob => new Promise((resolve, reject) => {
        const reader = new FileReader()
        reader.onloadend = () => resolve(reader.result)
        reader.onerror = reject
        reader.readAsDataURL(blob)
    }))

let imgUrl = $("#myimage").attr('src');

toDataURL('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbiwfNkcksmxA5POHDzLVTwvAB192GVaYTPNuHPs_13bla4Ju21Q')
    .then(dataUrl => {
        
        $("#myimage").attr('src', dataUrl)
        return dataUrl
    }).then((img)=>{
        
        $.ajax({
            method: 'POST',
            url: '/api/albums/addpicture',
            data: JSON.stringify({
                albumId: '1',
                pictureName: 'BATMAN',
                pictureLocation: 'in the bat cave',
                image: img
            }),
            contentType: 'application/json',
            dataType: 'json',
            success: (res) => {
                console.log(res);
            },
            error: (res) => {
                console.log(res);
            }
        })
    })


// ===============================
// DELETE IMAGE