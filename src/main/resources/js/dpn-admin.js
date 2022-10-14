(function ($) {
    $(document).ready(function() {
        const url = AJS.contextPath()+ "/rest/dpn/1.0/admin/configuration";
        $.ajax({
            url,
            dataType: "json"
        }).done(function(config) {
            $("#dpnSpaceKey").val(config.dpnSpaceKey);
            $("#requiredRole").val(config.requiredRole);
        })

        function updateConfig() {
            $("#successMessage").hide();
            AJS.$.ajax({
                url,
                type: "PUT",
                contentType: "application/json",
                data: '{ "dpnSpaceKey": "' + AJS.$("#dpnSpaceKey").attr("value") + '", "requiredRole": "' + AJS.$("#requiredRole").attr("value") + '" }',
                processData: false
            }).success(function() {
                $("#successMessage").show();
            })
        }

        AJS.$("#editDPNconfig").submit(function(e) {
            e.preventDefault();
            updateConfig();
        })

    })
})(AJS.$ || jQuery);

