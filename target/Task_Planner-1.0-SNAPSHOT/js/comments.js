$(document).ready(function() {
var comment = [];

for (var i = 0;i<comment.length; i++){
    render(comment[i]);
}

    $('#addComment').click(function () {

        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();

        today = mm + '/' + dd + '/' + yyyy;

        var addObj = {
            "name": $('#loggedInUser').val(),
            "date": today,
            "body": $('#commentBody').val()
        }

        comment.push(addObj);
        
    });
});

function render(data){
    var html = "<div class'commentBox'><div class='leftPanelImg'><img src='https://libertv.com/wp-content/uploads/2018/03/user-avatar-placeholder-1.png' /></div><div class='rightPanel'<span>"+data.name+"</span><div class='date-cell'>"+data.date+"</div><p>"+data.body+"</p></div><div class='clear'></div> </div>"
    $('#container').append(html);
};